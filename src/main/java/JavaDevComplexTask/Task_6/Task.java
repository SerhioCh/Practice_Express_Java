package JavaDevComplexTask.Task_6;

import java.time.LocalDate;
import java.util.Objects;

public class Task <T extends Number>  {
  private   T id;
  private  String status;
  private  String priority;
  private LocalDate date;

    public Task(T id, String status, String priority, LocalDate date) {
        this.id = id;
        this.status = status;
        this.priority = priority;
        this.date = date;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task<?> task = (Task<?>) o;
        return Objects.equals(id, task.id) && Objects.equals(status, task.status) && Objects.equals(priority, task.priority) && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, priority, date);
    }
}
