# Introducci贸n 馃殌
Este artefacto es un proyecto de automatizaci贸n de pruebas funcionales para crear un conocimiento en el protal de DYDU.

# Iniciando 
Contenido
1.	Lista de Features, Escenarios y casos prueba
2.	Software dependencies
3.	Arquitectura de la automatizaci贸n
4.	Ejecuci贸n de la automatizaci贸n

# Features, Escenarios y casos de prueba 馃搵
Los features tienen pasos en Background, esto para que se ejecuten siempre estos pasos antes de cada escenario.

1. Feature Login 
    @CorrectLogin
    -_Este escenario solo prueba el login correcto en el dashboard DYDU, en el Given despues de la palabra 'portal' se envia el parametro al stepDefinition para buscar la url a abrir

2. Feature Create BOT
    @create-bot
	    -_Este escenario solo prueba la correcta creacion de un BOT, el feature tiene un Background para iniciar sesion en el dashboard como prerequisito.	

3. Feature Create Know 
    Este feature tiene un Background para iniciar sesion en el dashboard como prerequisito en cada escenario de prueba.
    @create-a-bot-with-a-Knowledge
        -_Este escenario crea un bot y un conocimiento validando que el bot se cree correctamente y el conocimiento tambien.

	@create-know-to-bot-created	
        -_Este escenario crea un conocimiento eligiendo un bot creado previamente y se valida que el conocimiento se cree correctamente.

# Software dependencies 馃洜锔?
* El proyecto de automatizaci贸n esta construido con MAVEN
* Version de Serenity es la 2.2.11
* Version de cucumber es la 6.4.0

# Arquitectura de la automatizaci贸n 馃敡
La automatizaci贸n est谩 realizada con Serenity y con las capas que recomienda el patron Screenplay, se manejan pruebas controladas 
por el comportamiento BDD.
Las urls se cargan desde un archivo .properties localizado en la ruta src/test/resources/urls. Al metodo planteado en los StepDefinitions se debe enviar el key del valor de la url para abrir la pagina requerida, esto para abrir facilmente desde un parametro del feature Login cualquier url.

# Ejecuci贸n de la automatizaci贸n 鈿欙笍
Para ejecutar la automatizaci贸n y generar el reporte de las pruebas se debe realizar utilizando el siguiente comando:

* mvn verify -Duser=xxxxx -Dpassword=yyyyy

Por seguridad no se muestran las credenciales para acceder al portal entonces remplace las xxxxxx por el usuario y las yyyyyyy por la contrase帽a.

Para ejecutar la automatizacion desde un IDE de desarrollo parametrizar las siguientes varibales con su respectiva contrase帽a:
* -Duser=xxxxxx 
* -Dpassword=yyyyyy

Por seguridad no se muestran las credenciales para acceder al portal entonces remplace las xxxxxx por el usuario y las yyyyyyy por la contrase帽a.



### cristian.agu14@gmail.com saludos....

