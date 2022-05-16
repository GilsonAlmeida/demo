comando para rodar `docker-compose up`

#criar usuário POST localhost:8080/usuario
```JSON
{
    "login":"MARIA",
    "senha":"123",
    "ativo":true
    
}
```

#criar pauta POST localhost:8080/pauta
```JSON
{
    "descricao":"Concorda com o aumento do milho"
}
```


#criar sessão  POST localhost:8080/pauta
```JSON
{
    "tempo":120,
    "pauta": {
        "id":5
    }
}
```

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

#resultado GET `localhost:8080/pauta/5/resultado`
