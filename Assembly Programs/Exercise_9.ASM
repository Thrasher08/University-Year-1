; ----- EXAMPLE 4 ------- COUNTING AND JUMP --------------------------

	MOV	BL,1	; Initial value stored in BL

Rep:			; Jump back to this label
	MUL	BL,2	; Multiply 2 to BL
	JMP	Rep	; Jump back to Rep

			; When the count overflows the value becomes 0
	END		; Program Ends

; ===== Program Ends ===============================