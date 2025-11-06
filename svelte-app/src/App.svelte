<script>
	import Hijo from "./Hijo.svelte";
	export let name;
	let nombre;

	let contador = 0;
	function incrementar() {
		contador += 1;
	}

	function saludar() {
		alert(nombre ? nombre : "Hola nulo");
	}
</script>

<main>
	<p>Hola {name}!</p>
	<!-- <p>Visit the <a href="https://svelte.dev/tutorial">Svelte tutorial</a> to learn how to build Svelte apps.</p> -->
	<h1>Contar: {contador}</h1>
	<button on:click={incrementar}>Contar++</button>
	<Hijo texto="Guardar"></Hijo>
	<Hijo texto="Borrar" color="red"></Hijo>
	<input type="text" placeholder="Tu nombre" bind:value={nombre}/>
	<button on:click={saludar}>Saludar</button>
</main>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>
