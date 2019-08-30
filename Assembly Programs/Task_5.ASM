; ----- Task 5 ------- HEXADECIMAL --------------------------

; ===== CONTROL THE TRAFFIC LIGHTS =============================

	CLO		; Close unwanted windows.
Start:
			; Turn off all the traffic lights.
	MOV AL,0	; Copy 00000000 into the AL register.
	OUT 01		; Send AL to Port One (The traffic lights).
			; Turn on all the traffic lights.
	MOV AL,90	; Copy 10010000 into the AL register.
	OUT 01		; Send AL to Port One (Left(Red) (Right(Red)).
	MOV AL,98	; Copy 10011000 into the AL register.
	OUT 01		; Send AL to Port One (Left(Red) (Right(Red, Amber)).
	MOV AL,84	; Copy 10000100 into the AL register.
	OUT 01		; Send AL to Port One (Left(Red) (Right(Green)).
	MOV AL,88	; Copy 10001000 into the AL register.
	OUT 01		; Send AL to Port One (Left(Red) (Right(Amber)).
	MOV AL,90	; Copy 10010000 into the AL register.
	OUT 01 ;	; Send AL to Port One (Left(Red) (Right(Red)).
	MOV AL,D0	; Copy 11010000 into the AL register.
	OUT 01		; Send AL to Port One (Left(Red, Amber) (Right(Red)).
	MOV AL,30	; Copy 00110000 into the AL register.
	OUT 01		; Send AL to Port One (Left(Green) (Right(Red)).
	MOV AL,50	; Copy 01010000 into the AL register.
	OUT 01		; Send AL to Port One (Left(Amber) (Right(Red)).
	MOV AL,90	; Copy 10010000 into the AL register.
	OUT 01		; Send AL to Port One (Left(Red) (Right(Red)).
	JMP Start	; Jump back to the start.
	END		; Program ends.
	
; ===== Program Ends ==========================================