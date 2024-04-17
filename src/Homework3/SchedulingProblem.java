package Homework3;
import java.util.Arrays;

public class SchedulingProblem {

    // 作业类
    static class Job {
        String jobId;
        int time;

        Job(String jobId, int time) {
            this.jobId = jobId;
            this.time = time;
        }
    }


    public static double scheduleJobs(Job[] jobs) {
        // 按运行时间排序
        Arrays.sort(jobs, (a, b) -> a.time - b.time);

        int totalCompletionTime = 0;
        int currentTime = 0;
        for (Job job : jobs) {
            // 每个作业的完成时间是当前时间加上作业的运行时间
            currentTime += job.time;
            // 累加每个作业的完成时间
            totalCompletionTime += currentTime;
        }

        // 计算平均完成时间
        return (double)totalCompletionTime / jobs.length;
    }

    public static void main(String[] args) {
        Job[] jobs = {new Job("j1", 15), new Job("j2", 8), new Job("j3", 3), new Job("j4", 10)};
        double averageCompletionTime = scheduleJobs(jobs);

        // 输出排序后的作业顺序和平均完成时间
        System.out.println("Scheduled order of jobs:");
        for (Job job : jobs) {
            System.out.println(job.jobId + " (time: " + job.time + ")");
        }
        System.out.println("Average completion time: " + averageCompletionTime);
    }
}
