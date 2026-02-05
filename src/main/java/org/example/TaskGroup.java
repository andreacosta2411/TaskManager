package org.example;
// Importo ArrayList per creare una lista concreta.
import java.util.ArrayList;

// Importo List per usare l'interfaccia Lista.
import java.util.List;

//Importo Iterator.
import java.util.Iterator;




// Pattern Composite + Iterable
public class TaskGroup implements Task, Iterable<Task> {


    private String name;

    private List<Task> tasks = new ArrayList<>();
    //Lista interna dei task nel gruppo.


    public TaskGroup(String name) {

        this.name = name;
    }
    //Aggiunge un task al gruppo.
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override

    public String getName() {
        return name;
    }

    @Override // Uso  @Override  per sovrascrivere o modificare un comportamento predefinito.

    public Iterator<Task> iterator() {
        return tasks.iterator();

    }
}

