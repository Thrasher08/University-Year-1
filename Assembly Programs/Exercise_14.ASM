; ----- Task 5 ------- HEXADECIMAL --------------------------

; ===== CONTROL THE TRAFFIC LIGHTS =============================

; ----- Main Program -------------------------------------------

	CLO		; Close unwanted windows.
Start:
			; Turn off all the traffic lights.
	MOV AL,0	; Copy 00000000 into the AL register.
	OUT 01		; Send AL to Port One (The traffic lights).
			; Turn on all the traffic lights.

	MOV AL,90	; Copy 10010000 into the AL register.
	OUT 01		; Send AL to Port One (Left(Red) (Right(Red)).
	MOV	AL,8	; A short delay.
	CALL	60	; Call the procedure at address [60]
	MOV AL,98	; Copy 10011000 into the AL register.



	OUT 01		; Send AL to Port One (Left(Red) (Right(Red, Amber)).
	MOV	AL,8	; A short delay.
	CALL	60	; Call the procedure at address [60]
	MOV AL,84	; Copy 10000100 into the AL register.


	OUT 01		; Send AL to Port One (Left(Red) (Right(Green)).
	MOV	AL,8	; A short delay.
	CALL	60	; Call the procedure at address [60]
	MOV AL,88	; Copy 10001000 into the AL register.

	OUT 01		; Send AL to Port One (Left(Red) (Right(Amber)).
	MOV	AL,8	; A short delay.
	CALL	60	; Call the procedure at address [60]
	MOV AL,90	; Copy 10010000 into the AL register.

	OUT 01 ;	; Send AL to Port One (Left(Red) (Right(Red)).
	MOV	AL,8	; A short delay.
	CALL	60	; Call the procedure at address [60]
	MOV AL,D0	; Copy 11010000 into the AL register.

	OUT 01		; Send AL to Port One (Left(Red, Amber) (Right(Red)).
	MOV	AL,8	; A short delay.
	CALL	60	; Call the procedure at address [60]
	MOV AL,30	; Copy 00110000 into the AL register.

	OUT 01		; Send AL to Port One (Left(Green) (Right(Red)).
	MOV	AL,8	; A short delay.
	CALL	60	; Call the procedure at address [60]
	MOV AL,50	; Copy 01010000 into the AL register.

	OUT 01		; Send AL to Port One (Left(Amber) (Right(Red)).
	MOV	AL,8	; A short delay.
	CALL	60	; Call the procedure at address [60]
	MOV AL,90	; Copy 10010000 into the AL register.

	OUT 01		; Send AL to Port One (Left(Red) (Right(Red)).
	JMP Start	; Jump back to the start.

; ----- Time Delay Procedure Stored At Address [30] -------------
	ORG	60	; Generate machine code from address [30]

	PUSH	AL	; Save AL on the stack.
	PUSHF		; Save the CPU flags on the stack.
Rep:
	DEC	AL	; Subtract one from AL.
	JNZ	REP	; Jump back to Rep if AL was not Zero.

	POPF		; Restore the CPU flags from the stack.
	POP	AL	; Restore AL from the stack.

	RET		; Return from the procedure.

	END		; Program ends.
	
; ===== Program Ends ==========================================