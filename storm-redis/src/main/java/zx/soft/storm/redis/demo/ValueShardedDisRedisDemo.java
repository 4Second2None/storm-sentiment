package zx.soft.storm.redis.demo;

import zx.soft.storm.redis.shard.RedisCache;
import zx.soft.storm.redis.utils.Config;

public class ValueShardedDisRedisDemo {

	public static void main(String[] args) {

		RedisCache redisCache = new RedisCache(Config.get("redis.servers"), Integer.parseInt(Config.get("redis.port")),
				Config.get("redis.password"));
		String key = "record_key_md5";
		String[] members = { "v1", "v2", "v3", "v4", "v5", "v3" };
		redisCache.sadd(key, members);
		System.out.println(redisCache.scard(key));
		System.out.println(redisCache.sismember(key, "v3"));
		System.out.println(redisCache.sismember(key, "v6"));
		redisCache.sadd(key, "v5", "v7");
		System.out.println(redisCache.scard(key));
		System.out.println(redisCache.smembers(key));

	}

}
