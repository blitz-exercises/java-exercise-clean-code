# Script to decode base64 encoded violation markdown files
# Usage: .\decode-violations.ps1 [folder_name]
# If no folder is specified, decodes all violation files

$BaseDir = "src\main\java\nl\blitz\cleancode"

function Decode-Violations {
    param(
        [string]$FolderName = ""
    )
    
    if ([string]::IsNullOrEmpty($FolderName)) {
        # Decode all violation files
        $violationFiles = Get-ChildItem -Path $BaseDir -Filter "violations.md" -Recurse
        
        foreach ($file in $violationFiles) {
            $folder = $file.DirectoryName
            $folderName = Split-Path -Leaf $folder
            $outputFile = Join-Path $folder "violations-decoded.md"
            
            Write-Host "Decoding violations for folder: $folderName"
            
            try {
                $content = Get-Content $file.FullName -Raw
                $content = $content -replace "`r`n", "" -replace "`n", "" -replace "`r", "" -replace '\s+$', ''
                $decoded = [System.Text.Encoding]::UTF8.GetString([System.Convert]::FromBase64String($content))
                Set-Content -Path $outputFile -Value $decoded -Encoding UTF8
                Write-Host "  ✓ Decoded to: $outputFile" -ForegroundColor Green
            }
            catch {
                Write-Host "  ✗ Failed to decode: $($file.FullName)" -ForegroundColor Red
                Write-Host "    Error: $_" -ForegroundColor Red
            }
        }
    }
    else {
        # Decode specific folder
        $folderPath = Join-Path $BaseDir $FolderName
        $violationFile = Join-Path $folderPath "violations.md"
        $outputFile = Join-Path $folderPath "violations-decoded.md"
        
        if (Test-Path $violationFile) {
            Write-Host "Decoding violations for folder: $FolderName"
            
            try {
                $content = Get-Content $violationFile -Raw
                $content = $content -replace "`r`n", "" -replace "`n", "" -replace "`r", "" -replace '\s+$', ''
                $decoded = [System.Text.Encoding]::UTF8.GetString([System.Convert]::FromBase64String($content))
                Set-Content -Path $outputFile -Value $decoded -Encoding UTF8
                Write-Host "✓ Decoded to: $outputFile" -ForegroundColor Green
                Write-Host ""
                Write-Host $decoded
            }
            catch {
                Write-Host "✗ Failed to decode: $violationFile" -ForegroundColor Red
                Write-Host "Error: $_" -ForegroundColor Red
                exit 1
            }
        }
        else {
            Write-Host "✗ Violation file not found: $violationFile" -ForegroundColor Red
            exit 1
        }
    }
}

# Main execution
if ($args.Count -gt 0) {
    Decode-Violations -FolderName $args[0]
}
else {
    Decode-Violations
}

