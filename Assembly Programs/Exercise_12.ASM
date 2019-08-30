
; ----- EXAMPLE 5 ------- CHARACTER INPUT OUTPUT --------------------------

; --------------------------------------------------------------
;  Input key presses from the keyboard until Enter is pressed.
; --------------------------------------------------------------
	CLO		; Close unwanted windows.
	MOV BL,C0	; BL points to C0
Rep:
	IN	00	; Wait for key press - Store it in AL.
	CMP	AL,0D	; Was it the Enter key? (ASCII 0D)
	
	MOV [BL],AL	;Copies AL into RAM at BL
	INC BL		;Increases BL
	JNZ	Rep	; No - jump back.  Yes - end.

END
; --------------------------------------------------------------