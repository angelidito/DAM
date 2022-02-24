package com.examen.recmartinezangel.db;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\nJ \u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\nJ\u0018\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nJ\u0016\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/examen/recmartinezangel/db/ColegioDAO;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "a\u00f1adirFalta", "", "codigoAlumno", "", "fecha", "hora", "codigoProfesor", "comprobarFalta", "Lcom/examen/recmartinezangel/models/Falta;", "getAlumno", "Lcom/examen/recmartinezangel/models/Alumno;", "nombre", "hayRelacionProfesorAlumno", "", "logIn", "Lcom/examen/recmartinezangel/models/Profesor;", "login", "contrasena", "modificarObervacion", "falta", "Companion", "app_debug"})
public final class ColegioDAO {
    private final android.database.sqlite.SQLiteDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.examen.recmartinezangel.db.ColegioDAO.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "MartinezAngel";
    public static final int DATABASE_VERSION = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_ALUMNOS = "ALUMNOS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_FALTAS_ALUMNO = "FALTAS_ALUMNO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_PROFESOR = "PROFESOR";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TABLA_PROFESOR_ALUMNO = "PROFESOR_ALUMNO";
    
    public ColegioDAO(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.examen.recmartinezangel.models.Profesor logIn(@org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    java.lang.String contrasena) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.examen.recmartinezangel.models.Alumno getAlumno(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre) {
        return null;
    }
    
    public final boolean hayRelacionProfesorAlumno(@org.jetbrains.annotations.Nullable()
    java.lang.String codigoProfesor, @org.jetbrains.annotations.NotNull()
    java.lang.String codigoAlumno) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.examen.recmartinezangel.models.Falta comprobarFalta(@org.jetbrains.annotations.NotNull()
    java.lang.String codigoAlumno, @org.jetbrains.annotations.NotNull()
    java.lang.String fecha, @org.jetbrains.annotations.NotNull()
    java.lang.String hora) {
        return null;
    }
    
    public final void añadirFalta(@org.jetbrains.annotations.NotNull()
    java.lang.String codigoAlumno, @org.jetbrains.annotations.NotNull()
    java.lang.String fecha, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, @org.jetbrains.annotations.Nullable()
    java.lang.String codigoProfesor) {
    }
    
    public final void modificarObervacion(@org.jetbrains.annotations.NotNull()
    com.examen.recmartinezangel.models.Falta falta, @org.jetbrains.annotations.NotNull()
    java.lang.String codigoProfesor) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/examen/recmartinezangel/db/ColegioDAO$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "TABLA_ALUMNOS", "TABLA_FALTAS_ALUMNO", "TABLA_PROFESOR", "TABLA_PROFESOR_ALUMNO", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}