package pro.kensait.java.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

    private static final String HOSTNAME = "localhost";
    public static void main(String[] args) {

        InetAddress localhost = null;
        InetAddress host = null;
        try {
            localhost = InetAddress.getLocalHost();
            host = InetAddress.getByName(HOSTNAME);
        } catch (UnknownHostException uhe) {
            throw new RuntimeException(uhe);
        }

        System.out.println("Localhost Name => " + localhost.getHostName());
        System.out.println("Localhost IP Address => " + localhost.getHostAddress());
        System.out.println("Hostname => " + host.getHostName());
        System.out.println("IP Address => " + host.getHostAddress());
    }
}