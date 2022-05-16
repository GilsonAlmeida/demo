#criar usuário POST localhost:8080/usuario
{
    "login":"MARIA",
    "senha":"123",
    "ativo":true
    
}

#criar pauta POST localhost:8080/pauta
{
    "descricao":"Concorda com o aumento do milho"
}


#criar sessão  POST localhost:8080/pauta
{
    "tempo":120,
    "pauta": {
        "id":5
    }
}

#votar POST localhost:8080/voto
{
   "voto":"NAO",
   "usuario":{
       "id":1
   },
   "sessao": {
       "id":7
   }
}
#resultado GET localhost:8080/pauta/5/resultado
