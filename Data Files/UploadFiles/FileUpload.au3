Func _WinWaitActivate($title,$text,$timeout)
    $dHandle = WinWait($title,$text,$timeout)
    if not ($dHandle = 0) then
        If Not WinActive($title,$text) Then WinActivate($title,$text)
        WinWaitActive($title,$text,$timeout)
    Else
        Exit
    EndIf
	Return $dHandle
EndFunc

Local $hWnd = _WinWaitActivate($CmdLine[1], "", 2)

ControlFocus($hWnd, "", "Edit1")
ControlSend($hWnd, "", "Edit1", $CmdLine[2])

ControlFocus($hWnd, "", "Button1")
ControlClick($hWnd, "", "Button1")

Sleep(2000)