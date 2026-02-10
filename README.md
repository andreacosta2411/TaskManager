# TaskManager (Java)

Applicazione console per la gestione di una lista di task.
Il progetto consente di aggiungere, visualizzare, ordinare e filtrare task tramite un menu testuale.
È strutturato con Maven e include test automatici con JUnit.

---

Requisiti:
- Java (target: 8)
- Maven

---

Come eseguire:

Eseguire i test:
comando: mvn clean test

Avviare l’applicazione:
classe_principale: src/main/java/org/example/Main.java
ide: IntelliJ IDEA
azione: Run su Main

---

Funzionalità principali:
- Aggiunta di un task
- Visualizzazione della lista dei task
- Ordinamento dei task (A → Z)
- Ordinamento dei task (Z → A)
- Filtro dei task per parola chiave
- Uscita dall’applicazione

---

Persistenza dei dati:
repository: TaskFileRepository
file: tasks.txt
comportamento:
- load(): carica i task dal file
- save(): salva i task sul file
- TaskFactory utilizzata per creare i task

---

Design Pattern utilizzati:

Factory:
classe: TaskFactory
descrizione: Centralizza la creazione degli oggetti Task evitando l’uso diretto di new.

Composite:
interfaccia: Task
leaf: SimpleTask
composite: TaskGroup
descrizione: Permette di trattare task singoli e gruppi di task in modo uniforme.

Iterator:
classe: TaskGroup
descrizione: Implementa un iteratore custom depth-first per attraversare strutture di task annidate.

Exception Shielding:
descrizione:
- Gli errori non propagano eccezioni tecniche all’utente
- Messaggi user-friendly in console
- Dettagli tecnici registrati nel logger
- Nessun crash o stack trace visibile

Singleton:
classe: AppLogger
descrizione: Gestisce un’unica istanza condivisa di Logger per tutta l’applicazione.

Command (bonus):
interfaccia: Command
implementazioni:
- AddTaskCommand
- ListTasksCommand
- ListTasksAscCommand
- ListTasksDescCommand
- FilterTasksCommand
- ExitCommand
descrizione: Ogni voce di menu è incapsulata in un comando separato.

---

Logging:
tecnologia: java.util.logging
livelli:
- INFO
- WARNING
utilizzo: tracciamento avvio, operazioni principali ed errori

---

UML:
formato: PlantUML
cartella: docs/uml/
file:
- class-diagram.puml
- architecture.puml
visualizzazione:
- Plugin PlantUML per IntelliJ IDEA
- Strumenti online compatibili

---

Test:
framework: JUnit 5
copertura:
- creazione dei task
- gestione dei gruppi di task
- funzionamento dell’iteratore custom
- robustezza su input non valido

---

Note finali:
obiettivo:
- dimostrare l’uso dei principali design pattern
- organizzazione di un progetto Java con Maven
- attenzione alla qualità del codice e alla gestione degli errori
est