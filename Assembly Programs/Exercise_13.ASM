
; ----- EXAMPLE 5 ------- CHARACTER INPUT OUTPUT --------------------------

; --------------------------------------------------------------
;  Input key presses from the keyboard until Enter is pressed.
; --------------------------------------------------------------
	CLO		; Close unwanted windows.
	MOV BL,70	; BL points to 70
Rep:
	IN	00	; Wait for key press - Store it in AL.
	MOV [BL],AL	;Copies AL into RAM at BL
	INC BL		;Increases BL
	CMP	AL,0D	; Was it the Enter key? (ASCII 0D)
	JNZ	Rep	; No - jump back.  Yes - end.


	MOV BL,70
	MOV CL,C0

Rep2:

	MOV DL,[BL]
	MOV [CL],DL
	INC BL
	INC CL
	CMP DL,0D
	JNZ	Rep2

END
; --------------------------------------------------------------