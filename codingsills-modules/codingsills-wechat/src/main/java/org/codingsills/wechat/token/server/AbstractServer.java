package org.codingsills.wechat.token.server;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 中控服务器抽象类
 * AbstractServer.java
 *
 * @date 2016年8月3日
 * 
 * @author Saber
 */
public abstract class AbstractServer implements IServer {

    private static final Logger logger = LoggerFactory.getLogger(AbstractServer.class);

    protected String customerServerClass;

    public abstract String getCustomerServerClass();

    /**
     * AbstractServer.java 默认构造
     */
    public AbstractServer(){
        customerServerClass = getCustomerServerClass();
    }

    @Override
    public String token(){
        return server().token();
    }

    /**
     * 得到系统正在使用的中控服务器
     * @return
     * */
    public IServer server(){
        if(isCustomer()){
            return customerServer();
        }
        return defaultServer();
    }

    /**
     * 加载自定义中控服务器
     * 
     * */
    @SuppressWarnings("rawtypes")
    public IServer customerServer(){
        IServer customerServer = null;
        try{
            Class clazz = Class.forName(customerServerClass);
            customerServer = (IServer)clazz.newInstance();
        }
        catch(ClassNotFoundException e){
            logger.error("系统找不到{}", customerServerClass);
            e.printStackTrace();
        }
        catch(Exception e){
            logger.error("实例化{}失败", customerServerClass);
            e.printStackTrace();
        }
        return customerServer;
    }

    /**
     * 指定的默认中控服务器
     * @return 默认的中控服务器
     */
    public abstract IServer defaultServer();

    /**
     * 如果配置文件中配置了AccessTokenServer，那么使用客户自定义server
     * @return true：自定义，false:默认
     */
    public boolean isCustomer(){
        if(StringUtils.isBlank(customerServerClass)){
            return false;
        }
        return true;
    }
}
