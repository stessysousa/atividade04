<template>
  <div id="app">
    <div class="nav">
        <router-link to="/cadastrar">Cadastrar Carro  </router-link>
        <router-link to="/buscar">  Listar Carros  </router-link>
        <router-link to="/editar">  Editar Carro  </router-link>
        <router-link to="/filtrar">  Filtrar</router-link>
            
    </div>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.nav {
  display: flex;
  flex-direction: row;
  text-align: center;

}

.nav router-link {
  font-weight: bold;
  color: #2c3e50;
  text-align: center;

}

</style>
