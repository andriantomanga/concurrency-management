## POC sur la gestion de l'isolation Serializable par Spring-boot

L'objectif étant de démontrer que le niveau d'isolation ne permet l'execution que de la transaction du premier thread commitant parmi un certain nombre de threads s'executant en parallèle.

Pour executer, lancer le goal maven : 
```
mvn spring-boot:run
```

