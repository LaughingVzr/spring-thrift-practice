package com.vzr.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by Laughing_Vzr on 2015/1/7.
 */
public class Master implements Watcher {
    ZooKeeper zooKeeper;
    String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZooKeeper() throws IOException {
        zooKeeper = new ZooKeeper(hostPort, 15000, this);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        Master m = new Master(args[0]);
        m.startZooKeeper();

        // wait for a bit
        Thread.sleep(6000);
    }
}
