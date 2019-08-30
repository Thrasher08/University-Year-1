; ----- EXAMPLE 3 ------- USING ASCII CODES --------------------------

; ---------------------------------------------------------------
	CLO		; Close unwanted windows.
; ===== IMMEDIATE MOVES =====
	MOV	AL,48	; Copy 15 HEX into the AL register
	MOV	BL,45	; Copy 40 HEX into the BL register
	MOV	CL,4C	; Copy 50 HEX into the CL register
	MOV	DL,4F	; Copy 60 HEX into the DL register
Foo:
	
	
; ===== DIRECT MOVES =====
	MOV	[C0],AL	; Copy value in AL to RAM location [C0]
	MOV	[C1],BL	; Copy value in AL to RAM location [C1]
	MOV	[C2],CL	; Copy value in AL to RAM location [C2]
	MOV	[C3],CL	; Copy value in AL to RAM location [C3]
	MOV	[C4],DL	; Copy value in AL to RAM location [C4]
	
	JMP Foo		; PRESS ESCAPE TO STOP THE PROGRAM
	
	END
; ---------------------------------------------------------------