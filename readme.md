# InsertionSort Laufzeitanalyse

## 📌 Projektbeschreibung

Dieses Java-Projekt analysiert und visualisiert die Laufzeit des **InsertionSort-Algorithmus** unter verschiedenen Eingabeszenarien:

- **Best Case** (sortiertes Array)
- **Average Case** (zufälliges Array)
- **Worst Case** (rückwärts sortiertes Array)

Die Ergebnisse werden:

- **als Tabelle** in der Konsole ausgegeben
- **grafisch mit JFreeChart** visualisiert (farbig differenziert)

---

## 🛠️ Verwendete Technologien

- Java >=17
- Maven
- JFreeChart

---

## 📂 Projektstruktur

| Datei                        | Beschreibung                                            |
| ---------------------------- | ------------------------------------------------------- |
| `Main.java`                  | Fragt Eingaben ab, misst Laufzeit, zeigt Ergebnisse     |
| `InsertionSortAnalysis.java` | Enthält den Sortieralgorithmus und Testfall-Generatoren |
| `SortChart.java`             | Erstellt das Diagramm mit JFreeChart                    |

---

## ⚙️ Funktionsweise

1. Benutzer gibt Anzahl der zu testenden Array-Größen ein (z. B. 10 → `[10, 20, ..., 100]`)
2. Für jede Größe werden 3 Arrays generiert:
   - ✅ **Best Case**: bereits sortiert
   - 🎲 **Average Case**: zufällig
   - 🔻 **Worst Case**: rückwärts sortiert
3. Alle Arrays werden mit **InsertionSort** sortiert, die Laufzeit wird gemessen.
4. Ausgabe in Tabelle
5. Nach ENTER: Anzeige des Diagramms

---

## 🧠 Warum InsertionSort?

- **Einfach zu implementieren und verstehen**
- Ideal für die Analyse von Laufzeitverhalten je nach Eingabefall
- Nicht der effizienteste Algorithmus, aber perfekt zur Veranschaulichung von:
  - O(n²) (Worst Case)
  - Θ(n²) (Average Case)
  - Ω(n) (Best Case)

---

## ▶️ Ausführen

1. Stelle sicher, dass **Maven** installiert ist
2. Wechsle ins Projektverzeichnis
3. Kompilieren:
   ```bash
   mvn compile
   mvn exec:java
   ```
