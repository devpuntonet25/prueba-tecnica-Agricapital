## Prueba técnica backend Agricapital

# Breve explicación sobre el desarrollo del primer y segundo punto práctico
Este proyecto se construyó con springboot 3, utiliza mysql para persistir la información y también la implementación hibernate de JPA para gestionar las operaciones CRUD mediante este ORM.
El proyecto expone esencialmente 2 endpoints, el primero es para guardar un usuario en la base de datos luego de hacerle una validación al correo, y el segundo endpoint es para hacer paginación,
por tanto, pasando solo unos párametros como size, page, campo por el cual ordenar y tipo de ordenamiento retorna solo la cantidad limitada de regsitros y de acuerdo a lo especificado al hacer la petición.

# Sobre el tercer punto
En la carpeta raíz de este proyecto se encuentran dos imagenes que son el MER (modelo entidad relación) y MR (Modelo relacional) de la base de datos diseñada y creada para dar respuesta a este punto. También
se cuenta con un archivo SCRIPT_BD_TERCER_PUNTO.txt que contiene todo el script para crear la estructura de la base de datos junto con la consulta que trae los 5 clientes con el mayor total de compras.

# Sobre el cuestionario de conceptos técnicos
Se agregó también en la carpeta raíz de este proyecto, el archivo Respuestacuestionarioconceptosbasicos.pdf que contiene todas las respuestas del cuestionario

