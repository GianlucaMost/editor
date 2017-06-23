# editor
## Aufgabe
Entwicklung eines Text-Editors
- Drei-Schichten-Architektur
- Kommunikation zwischen der UI-Ebene und der Fachlogik existiert nur zwischen
  dem Controller und einer übergeordneten Klasse in der Fachlogik

- Funktionen im Hauptfenster (Buttons)
	- Neues Dokument
	- Laden
	- Speichern
	- Speichern unter
	- Löschen

  Listener auf den Buttons werden entweder als innere Klasse im Controller
  definiert oder als anonyme Klasse direkt auf dem Button registriert.

  Außerdem befindet sich das Texteingabefeld in diesem Fenster, welches
  als InternalFrame realisiert wird

- Das Speichern und Laden eines Dokumentes erfordert die Eingabe eines
  Dateipfades und eines Dateinamens.
  Dies wird umgesetzt indem ein Eingabefenster als Popup-Window genutzt wird
  Solange diese Fenster geöffnet sind, wird das Hauptfenster gemuted
  Zum Abrufen und Abspeichern der Daten die Klasse Java.io.File in
  Verbindung mit Reader und Writer Klassen verwenden

- Es sind Exception Klassen zu erstellen und  an geeigneten Stellen zur
  Behandlung von vorhersehbaren Fehlern (wie z.B. dem nicht finden einer
  zu ladenen Datei) zu benutzen. Die Exceptions müssen mindestens über eine Ebene weiter gereicht werden

- Für das Design der einzelnen Fenster ist das Grid sowie das BoxLayout in beliebigen
  Kombinationen zu verwenden
