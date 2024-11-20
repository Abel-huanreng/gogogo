package com.example.web;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author hejing
 * @date 2024/6/12:下午7:35
 */
public class ColoredPrintStream extends PrintStream {
    // ANSI 转义码
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public ColoredPrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public void println(String x) {
        super.println(ANSI_BLUE + x + ANSI_RESET);
    }

    @Override
    public void print(String s) {
        super.print(ANSI_BLUE + s + ANSI_RESET);
    }
}
