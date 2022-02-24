package com.examen.martinezangel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/examen/martinezangel/EmpresaDAO;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "a\u00f1adirProductoListaDeseos", "", "codigoProducto", "", "codigoUsuario", "eliminarProductoListaDeseos", "getCategorias", "", "Lcom/examen/martinezangel/Categoria;", "getProductosFrom", "Lcom/examen/martinezangel/Producto;", "categoria", "", "getProductosListaDeseos", "logIn", "", "login", "contrasena", "productoEnLista", "Companion", "app_debug"})
public final class EmpresaDAO {
    private final android.database.sqlite.SQLiteDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.examen.martinezangel.EmpresaDAO.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "EMPRESA";
    public static final int DATABASE_VERSION = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_CATEGORIAS = "CATEGORIAS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_PRODUCTOS = "PRODUCTOS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_USUARIOS = "USUARIOS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_LISTADESEOS = "LISTADESEOS";
    
    public EmpresaDAO(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final boolean logIn(@org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    java.lang.String contrasena) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.examen.martinezangel.Producto> getProductosFrom(@org.jetbrains.annotations.NotNull()
    java.lang.String categoria) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.examen.martinezangel.Categoria> getCategorias() {
        return null;
    }
    
    public final void añadirProductoListaDeseos(int codigoProducto, int codigoUsuario) {
    }
    
    public final void eliminarProductoListaDeseos(int codigoProducto, int codigoUsuario) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.examen.martinezangel.Producto> getProductosListaDeseos(int codigoUsuario) {
        return null;
    }
    
    public final boolean productoEnLista(int codigoProducto, int codigoUsuario) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/examen/martinezangel/EmpresaDAO$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "TABLA_CATEGORIAS", "TABLA_LISTADESEOS", "TABLA_PRODUCTOS", "TABLA_USUARIOS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}