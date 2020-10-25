<template>
  <div>
    <h3>Editar Carro</h3>
    <form>
      <label for="nome"
        >Id
        <input type="text" id="id" v-model="idCar" />
      </label>

      <label for="nome"
        >Nome
        <input type="text" id="nome" v-model="nome" />
      </label>

      <label for="marca"
        >Marca
        <input type="text" id="marca" v-model="marca" />
      </label>

      <label for="fabricacao"
        >Ano de Fabricação
        <input type="text" id="fabricacao" v-model="fabricacao" />
      </label>

      <label for="modelo"
        >Modelo
        <input type="text" id="modelo" v-model="modelo" />
      </label>

      <label for="data"
        >Data de Venda
        <input type="text" id="data" v-model="data" />
      </label>

      <button type="button" class="btn btn-primary" @click="editarCarro()">
        Editar Carro
      </button>

      <p>{{carro}}</p>
      
    </form>
  </div>
</template>

<script>
export default {
  name: "Editar",
  data: function () {
    return {
        idCar: "", 
        nome: "", 
        marca: "", 
        modelo: "", 
        fabricacao: "", 
        data: "",
      carro: {},
      baseURI: "http://localhost:8080/api/carros",

      carroAtualizado: {},
    };
  },
  methods: {
    editarCarro: function () {
      let obj = {

        id: this.idCar,
        nome: this.nome,
        marca: this.marca,
        modelo: this.modelo,
        fabricacao: this.fabricacao,
        data: this.data,
      };
console.log(this.idCar)
      this.$http.put(this.baseURI + "/" + this.idCar, obj).then((result) => {
        this.carro = result.data;
      });
    },
  },
};
</script>

<style>
</style>