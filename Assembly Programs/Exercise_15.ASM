; ----- EXAMPLE 7 ------- Passing Parameters -------------------

; ----- Use Registers to pass parameters into a procedure ------

	JMP 	Start	; Skip over bytes used for data storage

	DB	0	; Reserve a byte of RAM at address [02]
	DB	0	; Reserve a byte of RAM at address [03]
Start:
	MOV	AL,5
	MOV	BL,4
	CALL	30	; A procedure to add AL to BL
			; Result returned in AL.

; ----- A procedure to add two numbers -------------------------

;	Parameters passed into procedure using registers AL and BL
;	Result returned in AL
;	This method is simple but is no good if there are a 
;	lot of parameters to be passed.

	ORG	30	; Code starts at address [30]

	MUL	AL,02	; Do the addition.  Result goes into AL

	RET		; Return from the procedure

END