# M223: Punchclock
Diese Applikation ist mehrere Schnittstellen, um die Applikation Punchclock steuern zu können. Dazu hat die App noch ein 
UI, das die Schnittschtellen aufruft und für mehrere Funktionen nutzt.

Features:
- User verwalten
- Company verwalten
- Sign Up
- Login

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 11 installiert und in der Umgebungsvariable `path` definiert ist.
2. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console

Wichtige URLs:
- http://localhost:8081/sign-up neuen User erstellen und Passwort setzen
- http://localhost:8081/ mit bestehenden User einloggen (Mock User haben das Passwort -> a)
- http://localhost:8081/companyView.html UI, um die Entity Company zu verwalten
- http://localhost:8081/userView.html UI, um den User zu bearbeiten