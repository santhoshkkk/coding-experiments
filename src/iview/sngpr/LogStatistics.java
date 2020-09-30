package iview.sngpr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class LogStatistics {
    private final Map<String, FileStats> fileNameAndStats = new HashMap<>();
    private final PriorityQueue<FileStats> fileStatsQueue = new PriorityQueue<>(this::compareStats);
    private final String logFile;
    private final int limit;

    private LogStatistics(String file, int limit) {
        this.logFile = file;
        this.limit = limit;
    }

    public static void main(String[] args) {
        String report = new LogStatistics("server.log", 10).getMostFrequentFiles();
        System.out.println(report);
    }

    private int compareStats(FileStats stats1, FileStats stats2) {
        int diff = stats2.count - stats1.count;
        if (diff == 0) {
            diff = stats1.location.compareTo(stats2.location);
        }
        return diff;
    }

    String getMostFrequentFiles() {
        try (Stream<String> lines = Files.lines(Paths.get(logFile))) {
            lines.forEach(this::processLog);
            sort();
            int size = fileStatsQueue.size() >= limit ? limit : fileStatsQueue.size();
            return buildOutputString(size).toString();
        } catch (IOException ioException) {
            System.out.println(ioException);
            return "";
        }
    }

    private StringBuilder buildOutputString(int size) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < size; i++) {
            FileStats fileAccess = fileStatsQueue.poll();
            output.append(fileAccess.location).append(" ").append(fileAccess.size);
            if (i != size - 1) {
                output.append("\n");
            }
        }
        return output;
    }

    private void sort() {
        for (Map.Entry<String, FileStats> stringFileAccessEntry : fileNameAndStats.entrySet()) {
            fileStatsQueue.add(stringFileAccessEntry.getValue());
        }
    }

    private void processLog(String line) {
        String[] elements = line.split(" ");
        if ("200".equals(elements[5])) {
            FileStats[] fileAccess = new FileStats[1];
            if (fileNameAndStats.containsKey(elements[3])) {
                fileAccess[0] = fileNameAndStats.get(elements[3]);
                fileAccess[0].count++;
                fileAccess[0].size = fileAccess[0].size + Long.parseLong(elements[6]);
            } else {
                fileAccess[0] = new FileStats(1, elements[3], Long.parseLong(elements[6]));
                fileNameAndStats.put(elements[3], fileAccess[0]);
            }
        }
    }

    static class FileStats {
        int count;
        String location;
        long size;

        public FileStats(int count, String location, long size) {
            this.count = count;
            this.location = location;
            this.size = size;
        }

    }

}
