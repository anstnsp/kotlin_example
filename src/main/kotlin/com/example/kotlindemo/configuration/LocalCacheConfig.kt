package com.example.kotlindemo.configuration

import net.sf.ehcache.config.CacheConfiguration
import net.sf.ehcache.CacheManager
import org.springframework.cache.ehcache.EhCacheCacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@EnableCaching
class LocalCacheConfig {

    @Bean
    fun ehCacheManager(): CacheManager {
        val config = net.sf.ehcache.config.Configuration()
        config.addCache(cacheConfig("test", 100, 60))
        return CacheManager.newInstance(config)
    }

    private fun cacheConfig(cacheName: String, maxEntries: Long, ttl: Long): CacheConfiguration {
        return CacheConfiguration().apply {
            name = cacheName
            maxEntriesLocalHeap = maxEntries
            timeToLiveSeconds = ttl
            setMemoryStoreEvictionPolicy("LRU") //가장 최근에 사용되지않은 항목 순서대로 리스트에서 제거

        }
    }

    @Bean
    fun localCacheManager(): EhCacheCacheManager {
        return EhCacheCacheManager(ehCacheManager())
    }

}