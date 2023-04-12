import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;
import java.time.LocalDate;
import Task.*;
public class MemoReminder {
    private ArrayList<Task> taskList;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;

    public MemoReminder(){
        taskList=new ArrayList<Task>();
        scanner=new Scanner(System.in);
        dateFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }
    public void run() {
        boolean Running = true;
        while (Running) {
            System.out.println("1. 添加任务");
            System.out.println("2. 查看任务");
            System.out.println("3. 标记任务完成");
            System.out.println("4. 删除任务");
            System.out.println("5. 退出");
            System.out.print("请输入选项: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskCompleted();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    Running = false;
                    break;
                default:
                    System.out.println("无效选项");
            }
        }
    }

    private void deleteTask() {
        System.out.println("请输入你要删除的事件序号");
        int  tasknumber = scanner.nextInt();//读取想要删除的事件序号
        //想要删除的序号是否合法
        if(tasknumber<1||tasknumber>taskList.size()){
            System.out.println("输入的数字不合法，不存在该事件");
        }
        else{
            taskList.remove(tasknumber-1);
            System.out.println("任务已经删除");
        }
    }
/*使任务标记为完成*/
    private void markTaskCompleted() {
        //将任务对象的属性compete标记为完成
        System.out.println("请输入任务编号");
        int tasknumber=scanner.nextInt();
        if(tasknumber<1||tasknumber>taskList.size()){
            System.out.println("输入的数字不合法，或者该任务不存在");
        }
        else {
            Task temptask=taskList.get(tasknumber-1);
            temptask.markCompleted();
            System.out.println("任务已经标记为完成");
        }
    }

    private void viewTasks() {
        if(taskList.isEmpty()){
            System.out.println("没有任务");
        }
        else {
            for(int i=0;i<taskList.size();i++){
                Task task = taskList.get(i);
                System.out.printf("%d. %s (截止日期 %s)%n",i+1,task.getDescription(),task.getDueDate());
            }
        }
    }

    private void addTask() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要完成是事情");
        String thing=scan.nextLine();
        System.out.println("请输入截止时间格式为 ：yyyy-mm-dd");
        LocalDate dueDate=LocalDate.parse(scanner.nextLine(),dateFormatter);
        Task task=new Task(thing,dueDate);
        taskList.add(task);
        System.out.println("任务已添加");
    }

    public static void main(String[] args) {
        MemoReminder memoReminder = new MemoReminder();
        memoReminder.run();
    }

}

