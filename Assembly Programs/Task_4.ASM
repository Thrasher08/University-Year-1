; ----- Task 4 ------- ARITHMETIC --------------------------

; ===== WORK OUT 2 DIVIDED BY 0 ======================================
	CLO		; Close unwanted windows.
	MOV AL,6	; Copy a 2 into the AL register.
	MOV BL,2	; Copy a 0 into the BL register.
	DIV AL,BL	; Divide AL by BL. Answer goes into AL.
	END		; Program ends
; ===== Program Ends ===========================================

; Do not divide by 0
