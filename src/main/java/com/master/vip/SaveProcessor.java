package com.master.vip;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class SaveProcessor extends Thread implements IRequestProcessor{
    //阻塞队列
    LinkedBlockingQueue<Request> requests=new LinkedBlockingQueue<>();

    private IRequestProcessor nextProcessor;

    private volatile boolean isFinish=false;

    public SaveProcessor() {
    }

    public SaveProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
    public void shutdown(){ //对外提供关闭的方法
        isFinish=true;
    }

    @Override
    public void run() {
        while(!isFinish){ //不建议这么写
            try {
                Request request=requests.take();//阻塞式获取数据
                //真正的处理逻辑; store to mysql 。
                System.out.println("SaveProcessor:"+request);
                //交给下一个责任链
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(Request request) {
        //TODO 根据实际需求去做一些处理
        requests.add(request);
    }
}
