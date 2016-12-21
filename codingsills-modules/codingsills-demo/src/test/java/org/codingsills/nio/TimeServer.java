package org.codingsills.nio;


/**
 * 类功能描述
 * TimeServer.java
 *
 * @date 2016年12月21日
 * 
 * @author Saber
 */
public class TimeServer {
    
    public static void main(String[] args){
        int port = 8080;
        if(args != null && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }
            catch(Exception e){
                //采用默认端口
            }
        }
        
        //TODO 
    }
    
}
