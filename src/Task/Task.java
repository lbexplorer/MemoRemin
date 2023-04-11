package Task;

import java.time.LocalDate;

public class Task {
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    /*它将 Task 对象的 description 和 dueDate 字段设置为
    传入的参数值，并将 completed 字段设置为 false。
*/
    public Task(String description, LocalDate dueDate) {
        this.completed = false;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void markCompleted() {
        completed = true;
    }
}