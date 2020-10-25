<template>
  <div class="container">
    <h3>Listar todos os Carros?</h3>

    <button type="button" class="btn btn-primary" @click="fetchCarros">
      Clique Aqui!
    </button>

    <div class="esquerda-buscar">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Nome</th>
            <th scope="col">Marca</th>
            <th scope="col">Ano de Fabricação</th>
            <th scope="col">Ano de Modelo</th>
            <th scope="col">Data de Venda</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="carro in carros" v-bind:key="carro.id">
            <td>{{ carro.id }}</td>
            <td>{{ carro.nome }}</td>
            <td>{{ carro.marca }}</td>
            <td>{{ carro.modelo }}</td>
            <td>{{ carro.fabricacao }}</td>
            <td>{{ carro.data }}</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="direita-buscar">
      <h3>Digite um ID para Buscar um Carro ou Deletá-lo</h3>
      <input type="text" v-model="id" id="id" />
      <button class="btn btn-primary" id="buscarID" @click="fetchCarrosById">
        Buscar por ID!
      </button>

      <button class="btn btn-danger" id="buscarID" @click="deleteCarroById">
        Deletar por ID!
      </button>

      <p>ID: {{ carro.id }}</p>
      <p>Nome: {{ carro.nome }}</p>
      <p>Marca: {{ carro.marca }}</p>
      <p>Ano do Modelo: {{ carro.modelo }}</p>
      <p>Ano da Fabricação: {{ carro.fabricacao }}</p>
      <p>Data de Venda: {{ carro.data }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Buscar",
  data() {
    return {
      file: null,
      id: 0,
      nome: "",
      marca: "",
      fabricacao: "",
      modelo: "",
      data: "",

      carro: {},
      carros: [],
      baseURI: "http://localhost:8080/api/carros",
    };
  },

  methods: {
    fetchCarros: function () {
      this.$http.get(this.baseURI).then((result) => {
        this.carros = result.data;
      });
    },

    fetchCarrosById: function () {
      this.$http
        .get(this.baseURI + "/" + this.id)
        .then((result) => {
          this.carro = result.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    deleteCarroById: function() {
      this.$http.delete(this.baseURI + "/" + this.id).then((result) => {
        console.log(result.status);
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

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>