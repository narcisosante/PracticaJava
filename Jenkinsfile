Calendar calendar = Calendar.getInstance()
def dia = calendar.get(Calendar.DAY_OF_WEEK)
def diasSemana=[
    1:"Domingo",
    2:"Lunes",
    3:"Martes",
    4:"Miercoles",
    5:"Jueves",
    6:"Viernes",
    7:"Sabado"]
               
pipeline {
   agent any
   stages {
      stage('Jueves') {
        
         steps {
           script{
               
               if(diasSemana[dia] == "Jueves"){
                    println " ¿Que es un terapeuta? – 1024 Gigapeutas."
               }else{
                    println "error"
               }
               }  
         }
      }
      stage('Viernes') {
        
         steps {
           script{
              
               if(diasSemana[dia] == "Viernes"){
                    println "No me gusta especialmente el humor negro, pero no por rollos morales, me gusta respetar a todas las personas, incluso mascotas y mujeres"
               }else{
                    println "error" 
                    }
           }
         }
      }
        stage('Lunes') {
        
         steps {
           script{
              
               if(diasSemana[dia] == "Lunes"){
                    println "¿Como se llama el peor jugador japones? Nikito Nitoko."
               }else{
                    println "error" 
                    }
               }
               }  
         }
         stage('Martes') {
        
         steps {
           script{
              
               if(diasSemana[dia] == "Martes"){
                    println "¿En que se parece un mouse a un politico? En que si no lo presionas y arrastras no funcionan."
               }else{
                    println "error" 
                    }
               }
               }  
         }
         stage('Miercoles') {
        
         steps {
           script{
              
               if(diasSemana[dia] == "Miercoles"){
                    println "Doctor, doctor, ¿que tal ha salido la operación? -¡Pero que doctor ni que ocho cuartos! ¡Mire Ud. yo soy San Pedro!"
               }else{
                    println "error" 
                    }
               }
               }  
         }
      }
}
