package com.designpattern.utils;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import com.sun.management.OperatingSystemMXBean;

public class ResourceMonitor {

    private static final Runtime runtime = Runtime.getRuntime();
    private static final OperatingSystemMXBean osBean =
            ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    private static List<Double> cpuUsages = new ArrayList<>();
    private static List<Long> memoryUsages = new ArrayList<>();
    private static ResourceLogger logger = new ResourceLogger("log.log");

    public static void setCpuUsages(List<Double> cpuUsages) {
        ResourceMonitor.cpuUsages = cpuUsages;
    }

    public static void setMemoryUsages(List<Long> memoryUsages) {
        ResourceMonitor.memoryUsages = memoryUsages;
    }

    public void closeLogger(String fileName) {
        if (logger != null) logger.close();
    }

    public static void logMemoryUsage(String benchmarkName) {
        Long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        String msg = "Used Memory from " + benchmarkName + " : " + usedMemory / (1024*1024) + " MiB";
        if (logger != null) logger.log(msg);
        memoryUsages.add(usedMemory);
    }

    public static void logCpuUsage(String benchmarkName) {
        Double processCpuLoad = osBean.getProcessCpuLoad(); // 0.0 - 1.0
        String msg = "Process CPU Load from " + benchmarkName + " : " + (processCpuLoad * 100) + " %";
        if (logger != null) logger.log(msg);
        cpuUsages.add(processCpuLoad);
    }

    public static void logAverageCpu(String benchmarkName) {
        logger.log("Average CPU from " + benchmarkName + ": " + String.valueOf(cpuUsages.stream().mapToDouble(Double::doubleValue).average().orElse(0) * 100) + " %");
    }

    public static void logAverageMemory(String benchmarkName) {
        logger.log("Average Memory from " + benchmarkName + ": " + String.valueOf(memoryUsages.stream().mapToLong(Long::longValue).average().orElse(0) / (1024 * 1024) + " MiB"));
    }

    public static void logAll(String i) {
        logMemoryUsage(i);
        logAverageMemory(i);
        logCpuUsage(i);
        logAverageCpu(i);
        if (logger != null) logger.log("------------------------------------");
    }
}