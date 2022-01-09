package com.patika.bootcamp.patikabootcamp.movie;

import com.patika.bootcamp.patikabootcamp.movie.service.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean("movieRedisTemplate")
    public RedisTemplate<Long, Movie> movieRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<Long, Movie> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }
}
