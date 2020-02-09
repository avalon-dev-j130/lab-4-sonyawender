package ru.avalon.java.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Упражнение, на правленное на выработку умений, связанных с полученеим
 * сообщений, отправленных с использование протокола UDP.
 *
 * @author Daniel Alpatov
 */
public final class UdpReceiver {
    private static final int MAX_MESSAGE_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        // 1. Формиоуем буффер, для хранения получаемых данных.
        final byte[] buffer = prepareBuffer();
        // 2. Формируем пакет, на основе созданного буфера.
        final DatagramPacket packet = preparePacket(buffer);
        // 3. Выбираем порт, на который ожидается получение сообщения.
        final int port = 8080;
        // 4. Формируем сокет, связанный с выбранным портом.
        final DatagramSocket socket = prepareSocket(port);
        // 5. Получаем сообщение.
        socket.receive(packet);
        // 6. На основании данных пакета формируем текстовое сообщение.
        final String message = getMessage(packet);
        // 7. Освобождаем ресурсы.
        socket.close();
    }

    /**
     * Возвращает буффер, который будет испопльзован для храрнения получаемых данных.
     *
     * @return двоичный массив.
     */
    private static byte[] prepareBuffer() {
        /*
         * TODO Реализовать метод prepareBuffer класса UdpReceiver
         */
        return new byte[MAX_MESSAGE_SIZE];
    }

    /**
     * Упаковывает переданный двоичный массив (буффер) в экземпляр
     * типа {@link DatagramPacket}.
     *
     * @param buffer буффек, который будет использован пакетом для
     *               хранения получаемых данных.
     *
     * @return экземпляр типа {@link DatagramPacket}.
     */
    private static DatagramPacket preparePacket(byte[] buffer) {
        /*
         * TODO Реализовать метод preparePacket класса UdpReceiver
         */
        return new DatagramPacket(buffer, buffer.length);
    }

    /**
     * Возвращает сокет, связанный с указанным портом.
     *
     * @param port порт.
     *
     * @return сокет.
     */
    private static DatagramSocket prepareSocket(int port) {
        /*
         * TODO Реализовать метод prepareSocket класса UdpReceiver
         */
        try {
            DatagramSocket socket = new DatagramSocket(8080);
            return socket;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Преобразует данные, содержащиеся в полученном пакете в текстовое
     * представление.
     *
     * @param packet пакет.
     *
     * @return строковое сообщение.
     */
    private static String getMessage(DatagramPacket packet) {
        /*
         * TODO Реализовать метод getMessage класса UdpReceiver
         */
        try {
            String message = new String(packet.getData(), "UTF-8");
            return message;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
