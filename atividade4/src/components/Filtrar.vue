<template>
  <div>
    <div>
      <h2>Filtrar por Marca</h2>
      <input type="text" id="marca" v-model="marca">
      <button class="btn" id="filtrarMarca" @click="filtrarMarca()">Filtrar</button>
      <p v-for="carro in carros" :key="carro.id">ID: {{ carro.id }}</p>
      
    </div>

    <div>
      <h2>Filtrar por Quantidade</h2>
      <input type="text" id="marca">
      <button class="btn" id="filtrarQtd">Filtrar</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Filtrar",
  
  data() {
    return {
      file: null,
      id: "",
      nome: "",
      marca: "",
      fabricacao: "",
      modelo: "",
      data: "",

      carro: {},
      carros: [],
      baseURI: "http://localhost:8080/atividade04-backend/api/carros",
    };
  },

  methods: {

    filtrarMarca: function () {
      this.$http
        .get(this.baseURI + "/?marca=" + this.marca)
        .then((result) => {
          this.carro = result.data;
          console.log(this.carro)
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    
  },
};
</script>

<style>
* {
  padding: 0px;
  margin: 0px;
}
</style>