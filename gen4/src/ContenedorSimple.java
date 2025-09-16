public class ContenedorSimple  implements Contenedor<T> {
        private T elemento;

        @Override
        public void agregar(T elemento) {
            this.elemento = elemento;
        }

        @Override
        public T obtener() {
            return elemento;
        }

    }
