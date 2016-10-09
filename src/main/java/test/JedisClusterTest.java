//package test;
//
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeSet;
//
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//import com.alibaba.dubbo.rpc.RpcInvocation;
//import com.lvmama.comm.bee.vo.ord.Person;
//import com.lvmama.comm.lang.cache.CacheNullObject;
//import com.lvmama.comm.lang.serialize.HessionSerializeUtil;
//
//
//public class JedisClusterTest {
//
//    private static JedisCluster jedisCluster;
//    private static JedisPoolConfig poolConfig;
//    private static Set<HostAndPort> jedisClusterNodes;
//
//    private JedisClusterTest() {}
//
//    static {
//        jedisClusterNodes = getNodes("192.168.124.130:7000,192.168.124.130:7001");
//        poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(30);
//        poolConfig.setMaxIdle(20);
//        poolConfig.setMinIdle(10);
//        poolConfig.setBlockWhenExhausted(true);
//        poolConfig.setMaxWaitMillis(3000);
//        poolConfig.setTestOnBorrow(false);
//        poolConfig.setTestOnReturn(false);
//        poolConfig.setTestWhileIdle(false);
//        jedisCluster = new JedisCluster(jedisClusterNodes, 1000, 5, poolConfig);
//    }
//
//    private static Set<HostAndPort> getNodes(String redisServer) {
//        String[] servers = redisServer.replaceAll(" ", "").split(",");
//        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//        for (String ipPort : servers) {
//            String host = "127.0.0.1";
//            int port = 6379;
//            if (ipPort.contains(":")) {
//                host = ipPort.split(":")[0];
//                port = Integer.parseInt(ipPort.split(":")[1]);
//            } else {
//                host = ipPort;
//            }
//            jedisClusterNodes.add(new HostAndPort(host, port));
//        }
//        return jedisClusterNodes;
//    }
//
//    /**
//     * 删除对象
//     *
//     * @param key
//     * @return
//     */
//    public static boolean remove(String key) {
//        if (key == null) return false;
//        jedisCluster.del(key);
//        return true;
//    }
//    
//    /**
//     * 删除对象
//     *
//     * @param key
//     * @return
//     */
//    public static boolean removeMultiple(String... key) {
//        if (key == null) return false;
//        
//        for(String singleKey:key){
//            jedisCluster.del(singleKey);
//        }
//        
//        return true;
//    }
//
//    /**
//     * 缓存字符串对象
//     *
//     * @param key
//     * @param value
//     * @param seconds
//     * @return
//     */
//    public static boolean set(String key, String value, int seconds) {
//        assert (key == null) : "key is null";
//        assert (value == null) : "value is null";
//        assert (seconds <= 0) : "seconds less than 0";
//
//        String isOk = null;
//        if (value == null) {
//            isOk = jedisCluster.setex(key.getBytes(), seconds, HessionSerializeUtil.serialize(new CacheNullObject()));
//        } else {
//            isOk = jedisCluster.setex(key, seconds, value);
//        }
//        if (!"OK".equals(isOk)) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 获取字符串对象
//     *
//     * @param key
//     * @return
//     */
//    public static String get(String key) {
//        if (key == null) return null;
//        return jedisCluster.get(key);
//    }
//
//    /**
//     * 获取对象
//     *
//     * @param key
//     * @param clazz
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public static <T> T get(String key, Class<T> clazz) {
//        if (key == null) {
//            return null;
//        }
//        if (clazz == null) {
//            return null;
//        }
//        byte[] obj = jedisCluster.get(key.getBytes());
//        return (T) HessionSerializeUtil.deserialize(obj);
//    }
//
//    /**
//     * 获取对象
//     *
//     * @param key
//     * @return
//     */
//    public static Object getObject(String key) {
//        if (key == null) {
//            return null;
//        }
//        byte[] obj = jedisCluster.get(key.getBytes());
//        Object object = HessionSerializeUtil.deserialize(obj);
//        return object;
//    }
//
//    /**
//     * 缓存Object对象
//     *
//     * @param key
//     * @param value
//     * @param seconds
//     * @return
//     */
//    public static boolean set(String key, Object value, int seconds) {
//        assert (key == null) : "key is null";
//        assert (value == null) : "value is null";
//        assert (seconds <= 0) : "seconds less than 0";
//
//        String isOk = null;
//
//        if (value == null) {
//            isOk = jedisCluster.setex(key.getBytes(), seconds, HessionSerializeUtil.serialize(new CacheNullObject()));
//        } else {
//            isOk = jedisCluster.setex(key.getBytes(), seconds, HessionSerializeUtil.serialize(value));
//        }
//
//        if (!"OK".equals(isOk)) {
//            return false;
//        }
//        return true;
//    }
//    
//    public static Set<String> keys(String keyPattern) {
//        assert (keyPattern == null) : "keyPattern is null";
//        
//        TreeSet<String> keys = new TreeSet<String>();
//        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
//        for (String k : clusterNodes.keySet()) {
//            JedisPool jp = clusterNodes.get(k);
//            Jedis connection = jp.getResource();
//            try {
//                keys.addAll(connection.keys(keyPattern));
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            } finally {
//                connection.close();
//            }
//        }
//
//        return keys;
//    }
//
//    public static void main(String[] args) {
////        System.out.println("sssssssssssssssssssssssss");
////        set("test1", "test", 1000000);
////        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
////        set("DUBBO_com.lvmama.dubbo.service.DemoService_getPerson_invocation_", getInvocation(), 1000000);
////        Object obj = getObject("DUBBO_com.lvmama.dubbo.service.DemoService_getPerson_invocation_");
////        RpcInvocation invocation = (RpcInvocation) obj;
////        System.out.println(invocation);
//        Set<String> keys = keys("DUBBO_com.lvmama.cmt.api.service.CmtFrontCommentService_getCmtComment_invocation_");
//        System.out.println(keys);
////        JedisTest test = new JedisTest();
////        String key = "dubbo-cache_com.lvmama.dubbo.service.DemoService_getPerson";
////        byte[] value = HessionSerializeUtil.serialize(getInvocation());
////        System.out.println(value.toString());
//////        test.getJedis().setex(key.getBytes(), 1000000, value);
////        byte[] obj = test.getJedis().get(key.getBytes());
////        System.out.println(obj.toString());
////        RpcInvocation invocation = (RpcInvocation) HessionSerializeUtil.deserialize(obj);
////        System.out.println(invocation);
//    }
//
//    public static RpcInvocation getInvocation() {
//        RpcInvocation invocation=new RpcInvocation();
//        invocation.setAttachment("path", "com.lvmama.dubbo.service.DemoService");
//        invocation.setAttachment("interface", "com.lvmama.dubbo.service.DemoService");
//        invocation.setAttachment("timeout", "12000000");
//        invocation.setAttachment("version", "0.0.0");
//        invocation.setMethodName("getPerson");
//        invocation.setArguments(new Object[]{new Person()});
//        invocation.setParameterTypes(new Class[]{Person.class});
//
//        return invocation;
//    }
//}
