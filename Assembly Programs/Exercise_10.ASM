; ----- EXAMPLE 4 ------- COUNTING AND JUMP --------------------------

	MOV	BL,0	; Initial value stored in BL
	MOV	AL,1	; Initial value stored in AL
	MOV	[54],AL	; Move AL value to memory location 54

Rep:			; Jump back to this label
	
	ADD	BL,AL	; Add AL to BL
	MOV	AL,[54]	; Move memory value to AL
	MOV	[54],BL	; Move BL value to memory location 54
	
	
	JMP	Rep	; Jump back to Rep

			
	END		; Program Ends

; ===== Program Ends ===============================