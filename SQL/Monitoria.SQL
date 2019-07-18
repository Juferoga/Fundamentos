CREATE TABLE Asignatura
(
	k_asignatura   NUMBER(4) NOT NULL,
	n_nombre       VARCHAR(50) NOT NULL,
	t_descripcion  VARCHAR(50),

	CONSTRAINT check_k_asignatura CHECK (k_asignatura BETWEEN 0 and 9999),
	CONSTRAINT check_n_nombre CHECK (n_nombre != ''),
	CONSTRAINT k_asignatura_pk PRIMARY KEY (k_asignatura)
)
;


CREATE TABLE Chat
(
	k_num_mensaje    NUMBER(8) NOT NULL,
	d_hora_mensaje   DATE NOT NULL,
	d_fecha_mensaje  DATE NOT NULL,
	t_mensaje        VARCHAR(150) NOT NULL,
	k_id_solicitud   NUMBER(8) NOT NULL,

	CONSTRAINT check_k_num_mensaje CHECK (k_num_mensaje BETWEEN 0 and 9999),
	CONSTRAINT check_k_id_solicitud CHECK (k_id_solicitud BETWEEN 0 and 9999),
	CONSTRAINT check_t_mensaje CHECK (t_mensaje != ''),
	CONSTRAINT k_num_mensaje_pk PRIMARY KEY (k_num_mensaje),
	CONSTRAINT fk_solicitud FOREIGN KEY (k_id_solicitud) REFERENCES Solicitud(k_num_solicitud)
)
;


CREATE TABLE Estudiante
(
	k_codigo            NUMBER(8) NOT NULL,
	n_nombre             VARCHAR(30) NOT NULL,
	n_apellido           VARCHAR(30) NOT NULL,
	o_email              VARCHAR(50) NOT NULL,
	num_telefono         NUMBER(11) DEFAULT 0 NOT NULL,
	o_clave              VARCHAR(10) NOT NULL,
	t_programaAcademico  VARCHAR(50) NOT NULL,
	q_promedioM          NUMBER(2,1) DEFAULT 5 NOT NULL,
	q_promedioE          NUMBER(2,1) DEFAULT 5 NOT NULL,
	i_estado             CHAR(1) NOT NULL,

	CONSTRAINT k_codigo_pk PRIMARY KEY (k_codigo),
	CONSTRAINT check_k_codigo CHECK (k_codigo BETWEEN 0 and 9999),
	CONSTRAINT check_n_nombre CHECK (t_mensaje != ''),
	CONSTRAINT check_n_apellido CHECK (n_apellido != ''),
	CONSTRAINT check_o_email CHECK (o_email != '')
)
;


CREATE TABLE Estudiante_Solicitud
(
	k_cod_estudiante  NUMBER(8) NOT NULL,
	k_id_solicitud    NUMBER(8) NOT NULL

	CONSTRAINT k_cod_estudiante_pk PRIMARY KEY (k_cod_estudiante),
	CONSTRAINT fk_solicitud FOREIGN KEY (k_cod_estudiante) REFERENCES Estudiante(k_codigo),
	
	CONSTRAINT k_id_solicitud_pk PRIMARY KEY (k_id_solicitud),
	CONSTRAINT fk_solicitud FOREIGN KEY (k_id_solicitud) REFERENCES Solicitud(k_num_solicitud)
)
;


CREATE TABLE Monitoria
(
	k_num_monitoria           NUMBER(8) NOT NULL,
	d_fecha_monitoria         DATE,
	t_lugar                   VARCHAR(50) NOT NULL,
	i_estado                  CHAR(1) NOT NULL,
	t_descripcion_medico      VARCHAR(150),
	t_descripcion_estudiante  VARCHAR(150),
	k_id_solicitud            NUMBER(8) NOT NULL,

	CONSTRAINT k_num_monitoria_pk PRIMARY KEY (k_num_monitoria),
	CONSTRAINT fk_solicitud FOREIGN KEY (k_num_monitoria) REFERENCES Solicitud(k_num_solicitud),

	CONSTRAINT check_k_num_monitoria CHECK (k_num_monitoria BETWEEN 0 and 9999)
)
;


CREATE TABLE Recompensa
(
	k_recompensa             NUMBER(8) NOT NULL,
	n_nombre                 VARCHAR(50) NOT NULL,
	t_descripcion_recompnsa  VARCHAR(150),
	u_unidad                 VARCHAR(50) NOT NULL,
	k_tipo                   NUMBER(8) NOT NULL,

	CONSTRAINT k_recompensa_pk PRIMARY KEY (k_recompensa),
	CONSTRAINT fk_tipo FOREIGN KEY (k_tipo) REFERENCES Tipo(k_tipo),

	CONSTRAINT check_k_recompensa CHECK (k_recompensa BETWEEN 0 and 9999)
)
;


CREATE TABLE Solicitud
(
	k_num_solicitud      NUMBER(8) NOT NULL,
	i_estado             CHAR(1) NOT NULL,
	d_fecha_solicitud    DATE NOT NULL,
	num_estudiantes      NUMBER(2) NOT NULL,
	num_duracion         NUMBER(1) NOT NULL,
	k_codigo_estudiante  NUMBER(8) NOT NULL,
	k_cod_recompensa     NUMBER(8) NOT NULL,

	CONSTRAINT k_num_solicitud_pk PRIMARY KEY (k_num_solicitud),
	
	CONSTRAINT fk_cod_recompensa FOREIGN KEY (k_codigo_estudiante) REFERENCES Estudiante(k_codigo),
	CONSTRAINT fk_codigo_estudiante FOREIGN KEY (k_cod_recompensa) REFERENCES Recompensa(k_recompensa),

	CONSTRAINT check_k_num_solicitud CHECK (k_num_solicitud BETWEEN 0 and 9999)
)
;


CREATE TABLE Tema
(
	k_tema         NUMBER(8) NOT NULL,
	n_nombre       VARCHAR(150),
	k_asignaturaf  NUMBER(8) NOT NULL,

	CONSTRAINT k_tema_pk PRIMARY KEY (k_tema),
	
	CONSTRAINT fk_codigo_estudiante FOREIGN KEY (k_asignaturaf) REFERENCES Asignatura(k_asignatura),

	CONSTRAINT check_k_tema CHECK (k_tema BETWEEN 0 and 9999)
)
;


CREATE TABLE Tipo
(
	k_tipo         NUMBER(8) NOT NULL,
	n_nombre       VARCHAR(50) NOT NULL,
	t_descripcion  VARCHAR(150) NOT NULL,

	CONSTRAINT k_tipo_pk PRIMARY KEY (k_tipo),

	CONSTRAINT check_k_tipo CHECK (k_tipo BETWEEN 0 and 9999)
)
;


CREATE TABLE Solicitud_Tema
(
	k_solicitud  NUMBER(8) NOT NULL,
	k_tema       NUMBER(8) NOT NULL,

	CONSTRAINT k_solicitud_pk PRIMARY KEY (k_solicitud),
	CONSTRAINT fk_solicitud FOREIGN KEY (k_solicitud) REFERENCES Solicitud(k_num_solicitud),
	
	CONSTRAINT k_tema_pk PRIMARY KEY (k_tema),
	CONSTRAINT fk_tema FOREIGN KEY (k_tema) REFERENCES Tema(k_tema)
)
;