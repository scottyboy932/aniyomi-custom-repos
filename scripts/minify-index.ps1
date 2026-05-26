# Simple PowerShell script to minify index.json → index.min.json
# Run from the repo root:  .\scripts\minify-index.ps1

$ErrorActionPreference = "Stop"

$root = Split-Path $PSScriptRoot -Parent
$inputFile = Join-Path $root "index.json"
$outputFile = Join-Path $root "index.min.json"

if (-not (Test-Path $inputFile)) {
    Write-Error "index.json not found at $inputFile"
    exit 1
}

Write-Host "Reading $inputFile ..."
$json = Get-Content $inputFile -Raw | ConvertFrom-Json -Depth 100

$minified = $json | ConvertTo-Json -Depth 100 -Compress

Write-Host "Writing minified file to $outputFile ..."
Set-Content -Path $outputFile -Value $minified -NoNewline -Encoding UTF8

Write-Host "Done. Size reduced from $( (Get-Item $inputFile).Length ) to $( (Get-Item $outputFile).Length ) bytes."