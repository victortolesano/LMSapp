package com.br.herbalistapp.domain

data class Response (val cpf:String,val date_birth:String,val email:String,val name:String,val error:String){
    //verifica se a chamada foi feita com sucesso
    fun isOk()= "ok".equals(error,ignoreCase = true)
}