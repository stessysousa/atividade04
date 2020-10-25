<template>
  <div>
    <div class="corpo">
      <h3>Cadastrar Carros</h3>
      <form>
        <label for="nome"
          >Nome
          <input type="text" id="nome" v-model="carro.nome" />
        </label>

        <label for="marca"
          >Marca
          <input type="text" id="marca" v-model="carro.marca" />
        </label>

        <label for="fabricacao"
          >Ano de Fabricação
          <input type="text" id="fabricacao" v-model="carro.fabricacao" />
        </label>

        <label for="modelo"
          >Modelo do Carro
          <input type="text" id="modelo" v-model="carro.modelo" />
        </label>

        <label for="data"
          >Data de Venda
          <input type="text" id="data" v-model="carro.data"/>
        </label>

        <button type="button" class="btn btn-primary" v-on:click="cadastrarCarro()">Cadastrar</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Cadastrar",
  data() {
    return {
      baseURI: "http://localhost:8080/api/carros/",
      carro: {nome: "", marca: "", modelo: "", fabricacao: "", data: ""},
      
    };
  },

  methods: {
    cadastrarCarro: function () {
        this.$http.post(this.baseURI, this.carro).then((result) => {
          console.log(result.data.id)
        });
    },

    limparCarro: function () {
      this.carro = {};
    },
  },
};
</script>

<style scoped>

* {
  padding: 0px;
  margin: 0px;
}

.corpo {
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
}

</style>
