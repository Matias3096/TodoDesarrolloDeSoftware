package org.example.servicio;


import org.example.modelo.Empresa;

import java.util.HashSet;
import java.util.Set;

public class EmpresaServicio {

    private Set<Empresa> empresas = new HashSet<>();

    //Crear o guardar empresa

    public void guardar(Empresa empresa) {
        if (empresa == null) {
            System.out.println("No se puede guardar una empresa nula");
            return;
        }
        empresas.add(empresa);
    }
    //Listar todas las empresas
    public void listar() {
        if (empresas.isEmpty()) {
            System.out.println("No hay empresas registradas");
            return;
        }
        System.out.println("Lista de Empresas registradas");
        for (Empresa e : empresas) {
            mostrarDetalleEmpresa(e);
        }
    }
        //Buscar por ID
        public Empresa buscarXId(Integer id){
            if(id == null) return null;
            return empresas.stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }
        //Buscar por nombre
        public Empresa buscarXnombre(String nombre){
            if (nombre == null || nombre.isBlank()) return null;
            return empresas.stream()
                    .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                    .findFirst()
                    .orElse(null);
        }

        //Actualizar CUIT por ID
        public boolean actualizarCuit(Integer id, Long nuevoCuit){
            Empresa empresa = buscarXId(id);
            if(empresa != null){
                empresa.setCuit(nuevoCuit);
                return true;
            }
            return false;
        }
        //Eliminar empresa por ID
        public boolean eliminar(Integer id){
            if(id == null) return false;
            return empresas.removeIf(e->e.getId().equals(id));
        }
        //Mostrar detalle de empresa con sucursales
        private void mostrarDetalleEmpresa(Empresa empresa){
            if (empresa == null) return;

            System.out.println("Empresa ID: " +empresa.getId());
            System.out.println("Nombre: " + empresa.getNombre());
            System.out.println("Razon Social: " + empresa.getRazonSocial());
            System.out.println("CUIT: " + empresa.getCuit());
            System.out.println("Sucursales: ");
            if (empresa.getSucursales().isEmpty()){
                System.out.println("No hay sucursales");
            } else {
                empresa.getSucursales().forEach (s ->
                                System.out.println(" . " + s.getNombre() +
                                        " ( " + s.getDomicilio().getCalle() + " " +
                                        s.getDomicilio().getNumero() + " , " +
                                        s.getDomicilio().getLocalidad().getNombre() + " ) ")
                        );
            }
            System.out.println("-----------------------");

        }
    }

