
; ----- EXAMPLE - CONTROLLING THE LIFT --------------------------

	JMP	Start	; Skip to start

	DB	"UP    "	; Set Data Byte to UP	
	DB	"TOP   "	; Set Data Byte to TOP
	DB	"DOWN  "	; Set Data Byte to DOWN
	DB	"BOTTOM"	; Set Data Byte to BOTTOM
		
; ----- Start of program --------------------------
Start:
	CLO
	OUT	06		; Display lift window
	JMP	Loopup		; Jump to Loopup

; ----- Prints BOTTOM --------------------------

Displaybottom:
	MOV	CL,[DL]		; Moves memory location DL to CL
	MOV	[BL],CL		; BL points to the first byte in VDU
	INC	BL		; Increase BL
	INC	DL		; Increase DL
	CMP	BL,C6		; Compare BL with C6
	JNZ	Displaytop	; Jump to Displaytop

; ----- Reads Up Status --------------------------

Loopup:
	IN	06		; Read lift status
	AND	AL, 20		; Isolate UP button bit
	JZ	Loopdown	; Loop if UP button not pressed
	IN	06		; Read lift status
	JMP	setup		; Jump to setup

; ----- Prints TOP --------------------------

Displaytop:
	
	MOV	CL,[DL]		; Moves memory location DL to CL
	MOV	[BL],CL		; BL points to the first byte in VDU
	INC	BL		; Increase BL
	INC	DL		; Increase DL
	CMP	BL,C6		; Compare BL with C6
	JNZ	Displaytop	; Loop until all characters are printed

; ----- Reads Down Status --------------------------

Loopdown:
	IN	06		; Read lift status
	AND	AL, 10		; Isolate DOWN button bit
	JZ	Loopup		; Loop if DOWN button not pressed
	IN	06		; Read lift status
	JMP	setdown		; Jump to setdown


; ----- Sets Memory Location for TOP --------------------------
Settop:
	MOV	BL,C0		; Sets BL to C0
	JMP	Displaytop	; Jump to Display top

; ----- Sets Memory Location for BOTTOM --------------------------

Setbottom:
	MOV	DL,14		; Sets DL to 14 (B)
	MOV	BL,C0		; Sets BL to C0
	JMP	Displaybottom	; Jump to Displaybottom

; ----- Sets Memory Location for UP--------------------------

setup:
	MOV	DL,02		; Sets DL to 02 (U)
	MOV	BL,C0		; Sets BL to C0

; ----- Prints DOWN --------------------------

Displayup:
	
	MOV	CL,[DL]		; Moves memory location DL to CL
	MOV	[BL],CL		; BL points to the first byte in VDU
	INC	BL		; Increases BL
	INC	DL		; Increases DL
	CMP	BL,C6		; Compare BL with C6
	JNZ	Displayup	; Loop until all characters are printed

; ----- Moves Lift Up --------------------------

Up:
	AND	AL, DF		; Clear UP button bit
	OR	AL, 01		; Set UP motor bit
	OUT	06		; Reset UP button and turn on UP motor
	JMP	Stopup		; Jump to Stopup

; ----- Sets Memory Location for DOWN --------------------------

setdown:
	MOV	DL,0E		; Sets DL to 0E (D)
	MOV	BL,C0		; Sets BL to C0

; ----- Prints DOWN --------------------------

Displaydown:
	
	MOV	CL,[DL]		; Moves memory location DL to CL
	MOV	[BL],CL		; BL points to the first byte in VDU
	INC	BL		; Increases BL
	INC	DL		; Increases DL
	CMP	BL,C6		; Compare BL with C6
	JNZ	Displaydown	; Loop until all characters are printed

; ----- Moves Lift Down --------------------------

Down:
	AND	AL, EF		; Clear UP button bit
	OR	AL, 02		; Set UP motor bit
	OUT	06		; Reset UP button and turn on UP motor

; ----- Compares value of down sensor and up motor --------------------------

Stopdown:
	IN	06		; Input to lift
	AND 	AL,08		; Isolatate bottom sensor
	JZ	Stopdown	; Loop until sensor is activated

; ----- Stops lift going down --------------------------

	IN	06		; Input to lift
	AND	AL, 20		; Isolatate and clear down motor with bottom sensor active
	OUT	06		; Output to lift
	JMP	Setbottom	; Jump to Setbottom

; ----- Compares value of up sensor and up motor --------------------------

Stopup:
	IN	06		; Input to lift
	AND 	AL,04		; Isolatate top sensor
	JZ	Stopup		; Loop until sensor is activated

; ----- Stops lift going up --------------------------

	IN	06		; Input to lift
	AND	AL, 10		; Isolatate and clear up motor with top sensor active
	OUT	06		; Output to lift
	JMP	Settop		; Jump to Settop

	END
; --------------------------------------------------------------